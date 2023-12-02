import React, { useEffect, useState } from 'react';
import { findKillerByTrialId, findKillerImageByKillerName } from '../services/TrialAPI';

import tra from '../UI/Icons/CharPortraits/K01_TheTrapper_Portrait.png';
import clo from '../UI/Icons/CharPortraits/K12_TheClown_Portrait.png';
import mic from '../UI/Icons/CharPortraits/K06_TheShape_Portrait.png';

const KillerCard = ({ trialId }) => {
  const [killerView, setKillerView] = useState(null);
  const [killerCache, setKillerCache] = useState({});

  useEffect(() => {
    const loadKillerView = async () => {
      try {
        const killerName = await findKillerByTrialId(trialId);

        // checks to see if the result is already in the cache
        if (killerCache[killerName]) {
          setKillerView(killerCache[killerName]);
        } else {
          // if not in the cache, it will fetch the result
          const result = await findKillerImageByKillerName(killerName[0].killerName);

          // updates the cache with the new result
          setKillerCache((prevCache) => ({
            ...prevCache,
            [killerName]: result,
          }));

          setKillerView(result);
        }
      } catch (error) {
        console.error('Failed to load Killer view:', error);
      }
    };

    loadKillerView();
  }, [trialId, killerCache]); 

  if (!killerView) {
    return <div>Loading Killer...</div>;
  }

  switch(killerView.displayName){
    case 'The Trapper':
      killerView.image = tra;
      break;
    case 'The Clown':
      killerView.image = clo;
      break;
    case 'The Shape':  
      killerView.image = mic;
      break;
    default:
  }

  return (
    <div>
      <p>Killer: {killerView.displayName}</p>
      <img src={killerView.image} className="card-img-top" alt="Killer" />
    </div>
  );
};

export default KillerCard;
