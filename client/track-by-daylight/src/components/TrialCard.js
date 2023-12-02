import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import KillerCard from './KillerCard'; 
import Survivor1Card from "./Survivor1Card";
import Survivor2Card from "./Survivor2Card";
import Survivor3Card from "./Survivor3Card";
import Survivor4Card from "./Survivor4Card";

import AuthContext from "../contexts/AuthContext";
import { findMapByName } from "../services/TrickyApi";

import asy from '../UI/Icons/Maps/iconMap_Asy_Asylum.png';
import brl from '../UI/Icons/Maps/iconMap_Brl_MaHouse.png';
import gam from '../UI/Icons/Maps/iconMap_Fin_TheGame.png';

function TrialCard({ trial }) {

  const { user, hasAuthority } = useContext(AuthContext);
  const [mapView, setMapView] = useState(null);
  const [mapCache, setMapCache] = useState({});

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


  // Show a loading indicator while the view is being loaded
  if (!mapView) {
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


  return (
    <div className="col mb-4 center">
      <div className="card pinkbg">
      <h4>{mapView.name}</h4>
      <h5 className="card-title">Match Date: {trial.date}</h5>
        <img src={mapView.image} className="card-img-top" alt={trial.image} />
        <KillerCard trialId={trial.trialId} />
        <Survivor1Card trialId={trial.trialId}/>
        <Survivor2Card trialId={trial.trialId} />
        <Survivor3Card trialId={trial.trialId}/>
        <Survivor4Card trialId={trial.trialId}/>
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