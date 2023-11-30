import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import KillerCard from './KillerCard'; 
import asy from '../UI/Icons/Maps/iconMap_Asy_Asylum.png';
import brl from '../UI/Icons/Maps/iconMap_Brl_MaHouse.png';
import gam from '../UI/Icons/Maps/iconMap_Fin_TheGame.png';
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
import clo from '../UI/Icons/CharPortraits/K12_TheClown_Portrait.png';
import mic from '../UI/Icons/CharPortraits/K06_TheShape_Portrait.png';



import AuthContext from "../contexts/AuthContext";
import { findMapByName, findSurvivorByName } from "../services/TrickyApi";
import { findKillerByTrialId, findSurvivorByTrialId, findKillerImageByKillerName } from "../services/TrialAPI";

function TrialCard({ trial }) {

  const { user, hasAuthority } = useContext(AuthContext);
  const [mapView, setMapView] = useState(null);
  const [mapCache, setMapCache] = useState({});
  const [survivorView1, setSurvivorView1] = useState(null);
  const [s1Cache, setS1Cache] = useState({});
  const [survivorView2, setSurvivorView2] = useState(null);
  const [s2Cache, setS2Cache] = useState({});
  const [survivorView3, setSurvivorView3] = useState(null);
  const [s3Cache, setS3Cache] = useState({});
  const [survivorView4, setSurvivorView4] = useState(null);
  const [s4Cache, setS4Cache] = useState({});
  const [killerView, setKillerView] = useState(null);
  const [killerCache, setKillerCache] = useState({});

  //take Trapper killer from Json to use as image for fetch request. 

  useEffect(() => {
    const loadMapView = async () => {
      try {

        // checks to see if the result is already in the cache
        if (mapCache[trial.map.realmName]){
          setMapView(mapCache[trial.map.realmName]);
        } else {

          //if not in the cache it will fetch the result
          const result = await findMapByName(trial.map.realmName);

          //updates the cache with the new result
          setMapCache (prevCache => ({
            ...prevCache,
            [trial.map.realmName]: result
          }));

          setMapView(result);

        }
      } catch (error) {
        console.error("Failed to load map view:", error);
      }
    };

    loadMapView();
  }, [trial.map.realmName, mapCache]); // Only re-run the effect if realmName changes

  useEffect(() => {
    const loadSurvivorView1 = async () => {
      try {
      
      //check to see if result is already in cache 1

      if (s1Cache[trial.trialId]){
        setSurvivorView1(s1Cache[trial.trialId]);
        }
        else {
          //if it's not in the cache, fetch the new survivor name
          const survivorName = await findSurvivorByTrialId(trial.trialId);

          //fetch the survivor detauls using the survivor name
          const result = await findSurvivorByName(survivorName[0].survivorName);

          //Update the cache with the new result
          setS1Cache(prevCache => ({
            ...prevCache,
            [trial.trialId]: result
          }));

          // Set the survivor view State
          setSurvivorView1(result);
        }
      } catch (error) {
        console.error("Failed to load Survivor view:", error);
      }
    };

    loadSurvivorView1();
  }, [trial.trialId, s1Cache]); 

  useEffect(() => {
    const loadSurvivorView2 = async () => {
      try {
      
        //check to see if result is already in cache 2
  
        if (s2Cache[trial.trialId]){
          setSurvivorView2(s2Cache[trial.trialId]);
          }
          else {
            //if it's not in the cache, fetch the new survivor name
            const survivorName = await findSurvivorByTrialId(trial.trialId);
  
            //fetch the survivor detauls using the survivor name
            const result = await findSurvivorByName(survivorName[1].survivorName);
  
            //Update the cache with the new result
            setS2Cache(prevCache => ({
              ...prevCache,
              [trial.trialId]: result
            }));
  
            // Set the survivor view State
            setSurvivorView2(result);
          }
        } catch (error) {
          console.error("Failed to load Survivor view:", error);
        }
      };
  
      loadSurvivorView2();
    }, [trial.trialId, s2Cache]); 

  useEffect(() => {
    const loadSurvivorView3 = async () => {
      try {
      
        //check to see if result is already in cache 3
  
        if (s3Cache[trial.trialId]){
          setSurvivorView3(s3Cache[trial.trialId]);
          }
          else {
            //if it's not in the cache, fetch the new survivor name
            const survivorName = await findSurvivorByTrialId(trial.trialId);
  
            //fetch the survivor detauls using the survivor name
            const result = await findSurvivorByName(survivorName[2].survivorName);
  
            //Update the cache with the new result
            setS3Cache(prevCache => ({
              ...prevCache,
              [trial.trialId]: result
            }));
  
            // Set the survivor view State
            setSurvivorView3(result);
          }
        } catch (error) {
          console.error("Failed to load Survivor view:", error);
        }
      };
  
      loadSurvivorView3();
    }, [trial.trialId, s3Cache]); 

  useEffect(() => {
    const loadSurvivorView4 = async () => {
      try {
      
        //check to see if result is already in cache 1
  
        if (s2Cache[trial.trialId]){
          setSurvivorView4(s4Cache[trial.trialId]);
          }
          else {
            //if it's not in the cache, fetch the new survivor name
            const survivorName = await findSurvivorByTrialId(trial.trialId);
  
            //fetch the survivor detauls using the survivor name
            const result = await findSurvivorByName(survivorName[3].survivorName);
  
            //Update the cache with the new result
            setS4Cache(prevCache => ({
              ...prevCache,
              [trial.trialId]: result
            }));
  
            // Set the survivor view State
            setSurvivorView4(result);
          }
        } catch (error) {
          console.error("Failed to load Survivor view:", error);
        }
      };
  
      loadSurvivorView4();
    }, [trial.trialId, s4Cache]); 
    


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

  return (
    <div className="col mb-4 center">
      <div className="card pinkbg">
      <h4>{mapView.name}</h4>
      <h5 className="card-title">Match Date: {trial.date}</h5>
        <img src={mapView.image} className="card-img-top" alt={trial.image} />
        <KillerCard trialId={trial.trialId} />
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