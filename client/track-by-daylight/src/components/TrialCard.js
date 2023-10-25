import { useContext } from "react";
import { Link } from "react-router-dom";
import asy from '../UI/Icons/Maps/iconMap_Asy_Asylum.png';

import AuthContext from "../contexts/AuthContext";
import { findMapByName } from "../services/TrickyApi";

function TrialCard({ trial }) {

  const { user, hasAuthority } = useContext(AuthContext);

  const mapView = findMapByName(trial.map.realmName);


  return (

    <div className="col mb-4">
      <div className="card">
        <img src={mapView.image} className="card-img-top" alt={trial.image} />
        <div className="card-body">
          <h5 className="card-title">{trial.date}</h5>
          <h4>{trial.mapName}</h4>
        
          {/* {user && <Link to={`/game/edit/${trial.id}`} className="btn btn-dark">
            Edit
          </Link>}
          {user && hasAuthority('ADMIN') && <Link to={`/game/delete/${trial.id}`} className="btn btn-danger">
            Delete
          </Link>} */}
        </div>
      </div>
    </div>
  );
}

export default TrialCard;
