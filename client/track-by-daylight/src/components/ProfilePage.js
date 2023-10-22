import React, { useState, useEffect, useContext} from 'react';
import AuthContext from "../contexts/AuthContext";

import Loading from './Loading';
function ProfilePage(){

    const {user} = useContext(AuthContext);

    return (
        <div className="profile">
            <h2>User Profile</h2>
            {user && (
                <div className="username">
                    <strong>Username:</strong> {user.username}
                </div>
            )}
            {/* <div className="favorites">
                <h3>Top 5 Favorite Movies</h3>
                <ul>
                    {movies.slice(0, 5).map(movie => (
                        <li key={movie.favoriteId}>Movie ID: {movie.movieId}</li>
                    ))}
                </ul>
            </div> */}
        </div>
    );
}

export default ProfilePage;