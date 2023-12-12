import asy from '../UI/Icons/Maps/iconMap_Asy_Asylum.png';
import brl from '../UI/Icons/Maps/iconMap_Brl_MaHouse.png';
import gam from '../UI/Icons/Maps/iconMap_Fin_TheGame.png';

import { findMapByName } from "../services/TrickyApi";

import React, { useEffect, useState } from 'react';

const MapCard = ({trialMap}) => {
    const [mapView, setMapView] = useState(null);
    const [mapCache, setMapCache] = useState({});

    useEffect(() => {
        const loadMapView = async () => {
          try {
            console.log(trialMap);
          const mapName = await findMapByName(trialMap);

         // checks to see if the result is already in the cache
          if (mapCache[mapName]){
            setMapView(mapCache[mapName]);
            console.log(mapName);
            }
            else {
              //if it's not in the cache, fetch the new survivor name
              const result = await findMapByName(trialMap);
    
              //Update the cache with the new result
              setMapCache(prevCache => ({
                ...prevCache,
                [mapName]: result,
              }));
    
              // Set the survivor view State
              setMapView(result);
            }
          } catch (error) {
            console.error("Failed to load Map view:", error);
          }
        };
    
        loadMapView();
      }, [trialMap, mapCache, mapView]);

      
        // Show a loading indicator while the view is being loaded
        if (!mapView) {
            return <div>Loading...</div>;
        }

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
            <div>
            <h4>{mapView.name}</h4>
              <img src={mapView.image} className="card-img-top" alt={trialMap} />
            </div>
        )

}

export default MapCard;