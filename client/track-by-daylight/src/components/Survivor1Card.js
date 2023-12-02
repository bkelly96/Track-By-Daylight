import dwi from '../UI/Icons/CharPortraits/S01_DwightFairfield_Portrait.png';
import meg from '../UI/Icons/CharPortraits/S02_MegThomas_Portrait.png';
import cla from '../UI/Icons/CharPortraits/S03_ClaudetteMorel_Portrait.png';
import jak from '../UI/Icons/CharPortraits/S04_JakePark_Portrait.png';
import nea from '../UI/Icons/CharPortraits/S05_NeaKarlsson_Portrait.png';
import lau from '../UI/Icons/CharPortraits/S06_LaurieStrode_Portrait.png';
import ace from '../UI/Icons/CharPortraits/S07_AceVisconti_Portrait.png';
import bil from '../UI/Icons/CharPortraits/S08_WilliamBillOverbeck_Portrait.png';
import fen from '../UI/Icons/CharPortraits/S09_FengMin_Portrait.png';
import dav from '../UI/Icons/CharPortraits/S10_DavidKing_Portrait.png';
import kat from '../UI/Icons/CharPortraits/S13_KateDenson_Portrait.png';
import que from '../UI/Icons/CharPortraits/S11_QuentinSmith_Portrait.png';

import {  findSurvivorByName } from "../services/TrickyApi";
import { findSurvivorByTrialId } from '../services/TrialAPI';
import React, { useEffect, useState } from 'react';

const Survivor1Card = ({trialId}) => {
    const [survivorView1, setSurvivorView1] = useState(null);
    const [s1Cache, setS1Cache] = useState({});

    useEffect(() => {
        const loadSurvivorView1 = async () => {
          try {
          const survivorName = await findSurvivorByTrialId(trialId);

         // checks to see if the result is already in the cache
          if (s1Cache[survivorName]){
            setSurvivorView1(s1Cache[survivorName]);
            }
            else {
              //if it's not in the cache, fetch the new survivor name
              const result = await findSurvivorByName(survivorName[0].survivorName);
    
              //Update the cache with the new result
              setS1Cache(prevCache => ({
                ...prevCache,
                [survivorName]: result
              }));
    
              // Set the survivor view State
              setSurvivorView1(result);
            }
          } catch (error) {
            console.error("Failed to load Survivor view:", error);
          }
        };
    
        loadSurvivorView1();
      }, [trialId, s1Cache]); 

      if (!survivorView1) {
        return <div>Loading...</div>;
      }

      switch(survivorView1.image){
        case 'UI/Icons/CharPortraits/S01_DwightFairfield_Portrait.png':
          survivorView1.image = dwi;
          break;
        case 'UI/Icons/CharPortraits/S02_MegThomas_Portrait.png':
          survivorView1.image = meg;
          break;
        case 'UI/Icons/CharPortraits/S03_ClaudetteMorel_Portrait.png':  
          survivorView1.image = cla;
            break;
        case 'UI/Icons/CharPortraits/S04_JakePark_Portrait.png':
            survivorView1.image = jak;
            break;
        case 'UI/Icons/CharPortraits/S05_NeaKarlsson_Portrait.png':
            survivorView1.image = nea;
            break;
        case 'UI/Icons/CharPortraits/DLC2/S06_LaurieStrode_Portrait.png':  
          survivorView1.image = lau;
            break;
        case 'UI/Icons/CharPortraits/DLC3/S07_AceVisconti_Portrait.png':
              survivorView1.image = ace;
              break;
        case 'UI/Icons/CharPortraits/L4D/S08_WilliamBillOverbeck_Portrait.png':
              survivorView1.image = bil;
              break;
        case 'UI/Icons/CharPortraits/DLC4/S09_FengMin_Portrait.png':  
            survivorView1.image = fen;
              break;
        case 'UI/Icons/CharPortraits/DLC5/S10_DavidKing_Portrait.png':
            survivorView1.image = dav;
            break;
        case 'UI/Icons/CharPortraits/Guam/S13_KateDenson_Portrait.png':
            survivorView1.image = kat;
            break;
        case 'UI/Icons/CharPortraits/England/S11_QuentinSmith_Portrait.png':  
          survivorView1.image = que;
            break;
        default:
      }
    
      return (
        <div>
        <p> Survivor: {survivorView1.name}</p>
        <img src={survivorView1.image} className="card-img-top" alt="Survivor 1" />
        </div>
      )
    
}

export default Survivor1Card;