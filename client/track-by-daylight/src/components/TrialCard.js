import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import asy from '../UI/Icons/Maps/iconMap_Asy_Asylum.png';
import brl from '../UI/Icons/Maps/iconMap_Brl_MaHouse.png';
import gam from '../UI/Icons/Maps/iconMap_Fin_TheGame.png';
import dwi from '../UI/Icons/CharPortraits/DF_charSelect_portrait.png';
import meg from '../UI/Icons/CharPortraits/MT_charSelect_portrait.png';
import cla from '../UI/Icons/CharPortraits/CM_charSelect_portrait.png';
import jak from '../UI/Icons/CharPortraits/JP_charSelect_portrait.png';
import nea from '../UI/Icons/CharPortraits/NK_charSelect_portrait.png';
import lau from '../UI/Icons/CharPortraits/LS_charSelect_portrait.png';
import ace from '../UI/Icons/CharPortraits/AV_charSelect_portrait.png';
import bil from '../UI/Icons/CharPortraits/BO_charSelect_portrait.png';
import fen from '../UI/Icons/CharPortraits/FM_charSelect_portrait.png';
import dav from '../UI/Icons/CharPortraits/DK_charSelect_portrait.png';
import kat from '../UI/Icons/CharPortraits/GS_charSelect_portrait.png';
import que from '../UI/Icons/CharPortraits/QS_charSelect_portrait.png';
import tra from '../UI/Icons/CharPortraits/TR_charSelect_portrait.png';
import clo from '../UI/Icons/CharPortraits/GK_charSelect_portrait.png';
import mic from '../UI/Icons/CharPortraits/SH_charSelect_portrait.png';

import AuthContext from "../contexts/AuthContext";
import { findKillerByName, findMapByName, findSurvivorByName } from "../services/TrickyApi";
import { findKillerByTrialId, findSurvivorByTrialId } from "../services/TrialAPI";

function TrialCard({ trial }) {

  const { user, hasAuthority } = useContext(AuthContext);
  const [mapView, setMapView] = useState(null);
  const [survivorView1, setSurvivorView1] = useState(null);
  const [survivorView2, setSurvivorView2] = useState(null);
  const [survivorView3, setSurvivorView3] = useState(null);
  const [survivorView4, setSurvivorView4] = useState(null);
  const [killerView, setKillerView] = useState(null);

  useEffect(() => {
    const loadMapView = async () => {
      try {
        const result = await findMapByName(trial.map.realmName);
        setMapView(result);
      } catch (error) {
        console.error("Failed to load map view:", error);
      }
    };

    loadMapView();
  }, [trial.map.realmName]); // Only re-run the effect if realmName changes

  useEffect(() => {
    const loadSurvivorView1 = async () => {
      try {
        const survivorName = await findSurvivorByTrialId(trial.trialId);
        const result = await findSurvivorByName(survivorName[0].survivorName);
        setSurvivorView1(result);
      } catch (error) {
        console.error("Failed to load Survivor view:", error);
      }
    };

    loadSurvivorView1();
  }, [trial.trialId]); 

  useEffect(() => {
    const loadSurvivorView2 = async () => {
      try {
        const survivorName = await findSurvivorByTrialId(trial.trialId);
        const result = await findSurvivorByName(survivorName[1].survivorName);
        setSurvivorView2(result);
      } catch (error) {
        console.error("Failed to load Survivor view:", error);
      }
    };

    loadSurvivorView2();
  }, [trial.trialId]); 

  useEffect(() => {
    const loadSurvivorView3 = async () => {
      try {
        const survivorName = await findSurvivorByTrialId(trial.trialId);
        const result = await findSurvivorByName(survivorName[2].survivorName);
        setSurvivorView3(result);
      } catch (error) {
        console.error("Failed to load Survivor view:", error);
      }
    };

    loadSurvivorView3();
  }, [trial.trialId]); 

  useEffect(() => {
    const loadSurvivorView4 = async () => {
      try {
        const survivorName = await findSurvivorByTrialId(trial.trialId);
        const result = await findSurvivorByName(survivorName[3].survivorName);
        setSurvivorView4(result);
      } catch (error) {
        console.error("Failed to load Survivor view:", error);
      }
    };

    loadSurvivorView4();
  }, [trial.trialId]); 

  useEffect(() => {
    const loadKillerView = async () => {
      try {
        const killer = await findKillerByTrialId(trial.trialId);

        const result = await findKillerByName(killer[0].killerName);
        setKillerView(result);
      } catch (error) {
        console.error("Failed to load Killer view:", error);
      }
    };

    loadKillerView();
  }, [trial.trialId]); 

  // Show a loading indicator while the view is being loaded
  if (!mapView) {
    return <div>Loading...</div>;
  }

  if (!survivorView1) {
    return <div>Loading...</div>;
  }

  if (!survivorView2) {
    return <div>Loading...</div>;
  }


  if (!survivorView3) {
    return <div>Loading...</div>;
  }


  if (!survivorView4) {
    return <div>Loading...</div>;
  }


  if (!killerView) {
    return <div>Loading...</div>;
  }
 // mapview, import maps

  switch(mapView.image){
    case 'UI/Icons/Maps/iconMap_Asy_Asylum.png':
      mapView.image = asy;
      break;
    case 'UI/Icons/Maps/Saturn/iconMap_Brl_MaHouse.png':
      mapView.image = brl;
      break;
    case 'UI/Icons/Maps/Finland/iconMap_Fin_TheGame.png':  
      mapView.image = gam;
      break;
    default:
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

  switch(survivorView2.image){
    case 'UI/Icons/CharPortraits/S01_DwightFairfield_Portrait.png':
      survivorView2.image = dwi;
      break;
    case 'UI/Icons/CharPortraits/S02_MegThomas_Portrait.png':
      survivorView2.image = meg;
      break;
    case 'UI/Icons/CharPortraits/S03_ClaudetteMorel_Portrait.png':  
    survivorView2.image = cla;
        break;
    case 'UI/Icons/CharPortraits/S04_JakePark_Portrait.png':
      survivorView2.image = jak;
        break;
    case 'UI/Icons/CharPortraits/S05_NeaKarlsson_Portrait.png':
      survivorView2.image = nea;
        break;
    case 'UI/Icons/CharPortraits/DLC2/S06_LaurieStrode_Portrait.png':  
    survivorView2.image = lau;
        break;
    case 'UI/Icons/CharPortraits/DLC3/S07_AceVisconti_Portrait.png':
      survivorView2.image = ace;
          break;
    case 'UI/Icons/CharPortraits/L4D/S08_WilliamBillOverbeck_Portrait.png':
      survivorView2.image = bil;
          break;
    case 'UI/Icons/CharPortraits/DLC4/S09_FengMin_Portrait.png':  
    survivorView2.image = fen;
          break;
    case 'UI/Icons/CharPortraits/DLC5/S10_DavidKing_Portrait.png':
      survivorView2.image = dav;
        break;
    case 'UI/Icons/CharPortraits/Guam/S13_KateDenson_Portrait.png':
      survivorView2.image = kat;
        break;
    case 'UI/Icons/CharPortraits/England/S11_QuentinSmith_Portrait.png':  
    survivorView2.image = que;
        break;
    default:
  }


  switch(survivorView3.image){
    case 'UI/Icons/CharPortraits/S01_DwightFairfield_Portrait.png':
      survivorView3.image = dwi;
      break;
    case 'UI/Icons/CharPortraits/S02_MegThomas_Portrait.png':
      survivorView3.image = meg;
      break;
    case 'UI/Icons/CharPortraits/S03_ClaudetteMorel_Portrait.png':  
    survivorView3.image = cla;
        break;
    case 'UI/Icons/CharPortraits/S04_JakePark_Portrait.png':
      survivorView3.image = jak;
        break;
    case 'UI/Icons/CharPortraits/S05_NeaKarlsson_Portrait.png':
      survivorView3.image = nea;
        break;
    case 'UI/Icons/CharPortraits/DLC2/S06_LaurieStrode_Portrait.png':  
    survivorView3.image = lau;
        break;
    case 'UI/Icons/CharPortraits/DLC3/S07_AceVisconti_Portrait.png':
      survivorView3.image = ace;
          break;
    case 'UI/Icons/CharPortraits/L4D/S08_WilliamBillOverbeck_Portrait.png':
      survivorView3.image = bil;
          break;
    case 'UI/Icons/CharPortraits/DLC4/S09_FengMin_Portrait.png':  
    survivorView3.image = fen;
          break;
    case 'UI/Icons/CharPortraits/DLC5/S10_DavidKing_Portrait.png':
      survivorView3.image = dav;
        break;
    case 'UI/Icons/CharPortraits/Guam/S13_KateDenson_Portrait.png':
      survivorView3.image = kat;
        break;
    case 'UI/Icons/CharPortraits/England/S11_QuentinSmith_Portrait.png':  
    survivorView3.image = que;
        break;
    default:
  }


  switch(survivorView4.image){
    case 'UI/Icons/CharPortraits/S01_DwightFairfield_Portrait.png':
      survivorView4.image = dwi;
      break;
    case 'UI/Icons/CharPortraits/S02_MegThomas_Portrait.png':
      survivorView4.image = meg;
      break;
    case 'UI/Icons/CharPortraits/S03_ClaudetteMorel_Portrait.png':  
    survivorView4.image = cla;
        break;
    case 'UI/Icons/CharPortraits/S04_JakePark_Portrait.png':
      survivorView4.image = jak;
        break;
    case 'UI/Icons/CharPortraits/S05_NeaKarlsson_Portrait.png':
      survivorView4.image = nea;
        break;
    case 'UI/Icons/CharPortraits/DLC2/S06_LaurieStrode_Portrait.png':  
    survivorView4.image = lau;
        break;
    case 'UI/Icons/CharPortraits/DLC3/S07_AceVisconti_Portrait.png':
      survivorView4.image = ace;
          break;
    case 'UI/Icons/CharPortraits/L4D/S08_WilliamBillOverbeck_Portrait.png':
      survivorView4.image = bil;
          break;
    case 'UI/Icons/CharPortraits/DLC4/S09_FengMin_Portrait.png':  
    survivorView4.image = fen;
          break;
    case 'UI/Icons/CharPortraits/DLC5/S10_DavidKing_Portrait.png':
      survivorView4.image = dav;
        break;
    case 'UI/Icons/CharPortraits/Guam/S13_KateDenson_Portrait.png':
      survivorView4.image = kat;
        break;
    case 'UI/Icons/CharPortraits/England/S11_QuentinSmith_Portrait.png':  
    survivorView4.image = que;
        break;
    default:
  }
  
  switch(killerView.image){
    case 'UI/Icons/CharPortraits/K01_TheTrapper_Portrait.png':
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
    <div className="col mb-4 center">
      <div className="card pinkbg">
      <h4>{mapView.name}</h4>
      <h5 className="card-title">Match Date: {trial.date}</h5>
        <img src={mapView.image} className="card-img-top" alt={trial.image} />
        <p> Killer: {killerView.name}</p>
        <img src= {killerView.image} className="card-img-top" alt={trial.image} />
        <p> Survivor: {survivorView1.name}</p>
        <img src={survivorView1.image} className="card-img-top" alt={trial.image} />
        <p> Survivor: {survivorView2.name}</p>
        <img src={survivorView2.image} className="card-img-top" alt={trial.image} />
        <p> Survivor: {survivorView3.name}</p>
        <img src={survivorView3.image} className="card-img-top" alt={trial.image} />
        <p> Survivor: {survivorView4.name}</p>
        <img src={survivorView4.image} className="card-img-top" alt={trial.image} />
        <div className="card-body">
         
       
          {user && <Link to={`/trial/edit/${trial.id}`} className="button-2">
            Edit
          </Link>}
          {user && hasAuthority('ADMIN') && <Link to={`/trial/delete/${trial.id}`} className="button-1">
            Delete
          </Link>}
        </div>
      </div>
    </div>
  );
}

export default TrialCard;