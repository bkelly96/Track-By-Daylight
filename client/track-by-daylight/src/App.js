
import { useEffect, useState, useCallback } from "react";
import { refreshToken, logout } from "./services/AuthAPI";
import LoginPage from "./components/LoginPage";
import NotFound from "./components/NotFound";
import AuthContext from "./contexts/AuthContext"
import ProfilePage from "./components/ProfilePage";
import {useQuery, useMutation} from "@tanstack/react-query";
import Nav from './components/Nav';



import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';

const TIMEOUT_MILLISECONDS = 14 * 60 * 1000;

function App() {
  const [user, setUser] = useState();
  const [initialized, setInitialized] = useState(false);

  const resetUser = useCallback(() => {
    refreshToken()
      .then((user) => {
        setUser(user);
        setTimeout(resetUser, TIMEOUT_MILLISECONDS);
      })
      .catch((err) => {
        
      })
      .finally(() => setInitialized(true));
  }, []);

  useEffect(() => {
    resetUser();
  }, [resetUser]);

  const auth = {
    user: user,
    handleLoggedIn(user) {
      setUser(user);
      setTimeout(resetUser, TIMEOUT_MILLISECONDS);
    },
    hasAuthority(authority) {
      return user?.authorities.includes(authority);
    },
    logout() {
      logout();
      setUser(null);
    },
  };

  if (!initialized) {
    return null;
  }

  const renderWithAuthority = (Component, ...authorities) => {
    for (let authority of authorities) {
      if (auth.hasAuthority(authority)) {
        return <Component />;
      }
    }
    return <NotFound />;
  };

  return (
    <>
    <AuthContext.Provider value={auth}>
    <Router>
      <Nav></Nav>
      <main>
      <Routes>
      <Route path='/' element={<LoginPage/>} />
      <Route path='/profile' element={ <ProfilePage/>} />
      <Route path='*' element={<NotFound/>} />
      <Route
       path='/profile'
       element={renderWithAuthority(ProfilePage, "USER", "ADMIN")}
      />
      </Routes>
      </main>
    </Router>
    </AuthContext.Provider>
   </>
  );
}

export default App;
