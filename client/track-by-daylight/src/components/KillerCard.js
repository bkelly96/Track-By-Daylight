import React, { useEffect, useState } from 'react';
import { findKillerByTrialId, findKillerImageByKillerName } from '../services/TrialAPI';

import tra from '../UI/Icons/CharPortraits/K01_TheTrapper_Portrait.png';
import clo from '../UI/Icons/CharPortraits/K12_TheClown_Portrait.png';
import mic from '../UI/Icons/CharPortraits/K06_TheShape_Portrait.png';

const KillerCard = ({ trialId }) => {
  const [killerView, setKillerView] = useState(null);

  useEffect(() => {
    const loadKillerView = async () => {
      try {
        const killerName = await findKillerByTrialId(trialId);
        const result = await findKillerImageByKillerName(killerName[0].killerName);
        setKillerView(result);
      } catch (error) {
        console.error('Failed to load Killer view:', error);
      }
    };

    loadKillerView();
  }, [trialId]);

  if (!killerView) {
    return <div>Loading Killer...</div>;
  }

  switch(killerView.displayName){
    case 'The Trapper':
      killerView.image = tra;
      break;
    case 'UI/Icons/CharPortraits/Guam/K12_TheClown_Portrait.png':
      killerView.image = clo;
      break;
    case 'UI/Icons/CharPortraits/DLC2/K06_TheShape_Portrait.png':  
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
