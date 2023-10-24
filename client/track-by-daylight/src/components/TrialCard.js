import { useContext } from "react";
import { Link } from "react-router-dom";

import AuthContext from "../contexts/AuthContext";
import { findMapByName } from "../services/TrickyApi";

function TrialCard({ trial }) {
    console.log(trial);
    console.log(trial.map.realmName);
    const mapView = findMapByName(trial.map.realmName);
  const { user, hasAuthority } = useContext(AuthContext);

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
