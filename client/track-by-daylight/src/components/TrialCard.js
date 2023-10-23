import { useContext } from "react";
import { Link } from "react-router-dom";

import AuthContext from "../contexts/AuthContext";

function TrialCard({ trial }) {

  const { user, hasAuthority } = useContext(AuthContext);

  return (
    <div className="col mb-4">
      <div className="card">
        <img src={trial.image} className="card-img-top" alt={trial.image} />
        <div className="card-body">
          <h5 className="card-title">{trial.date}</h5>
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
