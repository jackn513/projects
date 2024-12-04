import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Register from './views/register.tsx';
import NavBar from './components/nav-bar.tsx';
import Login from './views/login.tsx';
import Home from "./views/home.tsx";
import Logout from "./components/logout.tsx";
import { UserProvider } from "./assets/userContext.tsx";

function App() {
    const [user, setUser] = useState(null);
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        // Check if there's a token in localStorage to set the logged in state
        const token = localStorage.getItem("token");
        if (token) {
            setIsLoggedIn(true);
            // Optionally, you can retrieve the user details from localStorage as well

        }
    }, []); // Empty dependency array to only run on component mount

    return (
        <Router>
            <UserProvider>
                <NavBar user={user} isLoggedIn={isLoggedIn} />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/login" element={<Login setUser={setUser} setIsLoggedIn={setIsLoggedIn} />} />
                    <Route path="/logout" element={<Logout setIsLoggedIn={setIsLoggedIn} />} />
                </Routes>
            </UserProvider>
        </Router>
    );
}

export default App;
