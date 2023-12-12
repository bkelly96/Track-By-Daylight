import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import KillerCard from './KillerCard'; 
import MapCard from "./MapCard";
import Survivor1Card from "./Survivor1Card";
import Survivor2Card from "./Survivor2Card";
import Survivor3Card from "./Survivor3Card";
import Survivor4Card from "./Survivor4Card";

import AuthContext from "../contexts/AuthContext";

function TrialCard({ trial }) {

  const { user, hasAuthority } = useContext(AuthContext);

  console.log(trial);

  return (
    <div className="col mb-4 center">
      <div className="card pinkbg">
      <h5 className="card-title">Match Date: {trial.date}</h5>
        <MapCard trialMap={trial.map.realmName} />
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