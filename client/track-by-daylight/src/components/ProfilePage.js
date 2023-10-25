import React, { useState, useEffect, useContext} from 'react';
import { useNavigate, Link } from "react-router-dom";
import { findMapByName } from '../services/TrickyApi';
import AuthContext from "../contexts/AuthContext";
import TrialCard from './TrialCard';

import Loading from './Loading';
import { findTrialByUsername } from '../services/TrialAPI';

function ProfilePage(){

    const token = `${process.env.REACT_APP_TRICKY_TOKEN}`
    const [trials, setTrials] = useState([]);
    const navigate = useNavigate();

    const {user} = useContext(AuthContext);

    useEffect(() => {
     findTrialByUsername(user.username)
     .then((data) => setTrials(data))
     .catch((err)=>
     navigate("/error", {
        state: {message: err},
        })
     );   
    }, [navigate, user.username]);
    

    return (
        <div className="profile">
            <h2>User Profile</h2>
            {user && (
                <div className="username">
                    <strong>Username:</strong> {user.username}
                </div>
            )}
            <div>
                <div className="d-flex justify-content-between">
                    <div className="me-auto p-2 bd-highlight">
                    <h2>Trials</h2>
                    </div>
                    <div className="p-2 bd-highlight">
                    {/* {user && (
                        <Link to="/game/add" className="btn btn-secondary">
                        Add Board Game
                        </Link>
                    )} */}
                    </div>
                </div>
                <div className="row row-cols-1 row-cols-md-2 row-cols-lg-4">
                    {trials.length === 0 ? (
                    <div className="alert alert-info">
                        Nothing here yet, add a trial!
                    </div>
                    ) : (
                    trials.map((trial) => <TrialCard key={trial.id} trial={trial} />)
                    )}
                </div>
                </div>
        </div>
    );
}

export default ProfilePage;