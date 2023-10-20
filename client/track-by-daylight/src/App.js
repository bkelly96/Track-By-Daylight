import logo from './logo.svg';
import './App.css';
import { useState, useEffect } from "react";
import jwtDecode from "jwt-decode";

const LOCAL_STORAGE_TOKEN_KEY = "trackByDaylightToken";

function App() {

  const [user, setUser] = useState(null);
  const [restoreLoginAttemptCompleted, setRestoreLoginAttemptCompleted] = useState(false);


  
  useEffect(() => {
    const token = localStorage.getItem(LOCAL_STORAGE_TOKEN_KEY);
    if (token) {
      login(token);
    }
    setRestoreLoginAttemptCompleted(true);
  }, []);

  
  const login = (token) => {
    localStorage.setItem(LOCAL_STORAGE_TOKEN_KEY, token);

    // Decode the token
    const { sub: username, authorities: authoritiesString } = jwtDecode(token);
  
    // Split the authorities string into an array of roles
    const roles = authoritiesString.split(',');
  
    // Create the "user" object
    const user = {
      username,
      roles,
      token,
      hasRole(role) {
        return this.roles.includes(role);
      }
    };

        // Log the user for debugging purposes
        console.log(user);
  
        // Update the user state
        setUser(user);
      
        // Return the user to the caller
        return user;
      };

      const logout = () => {
        setUser(null);
        localStorage.removeItem(LOCAL_STORAGE_TOKEN_KEY);
      };
    
      const auth = {
        user: user ? { ...user } : null,
        login,
        logout
      };

            // If we haven't attempted to restore the login yet...
      // then don't render the App component
      if (!restoreLoginAttemptCompleted) {
        return null;
      }

      
  

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
