import React, { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import '../styles/nav-bar.css';
import axios from 'axios';

function NavBar() {
    const [user, setUser] = useState(null); // Store user data
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        const token = localStorage.getItem("token");

        if (token) {
            const fetchUserData = async () => {
                try {
                    const response = await axios.get('http://localhost:3000/users/my-details', {
                        headers: {
                            Authorization: `Bearer ${token}`,
                        }
                    });
                    setUser(response.data);
                    console.log(response.data);
                    setIsLoggedIn(true);

                } catch (error) {
                    console.error("Error fetching user data", error);
                    setIsLoggedIn(false);
                }
            };

            fetchUserData().then();
        } else {
            setIsLoggedIn(false);
        }
    }, [localStorage.getItem("token")]);

    return (
        <section className="nav-bar">
            <ul className="links-nav">
                <li>
                    <NavLink
                        to="/"
                        end
                        className={({ isActive }) => (isActive ? 'active' : '')}
                        id="home"
                        aria-current="page"
                    >
                        Home
                    </NavLink>
                </li>
            </ul>

            <div className="dropdown">
                <button className="dropbtn">
                    {user?.Username?.[0] || null}
                </button>
                <div className="dropdown-content">
                    {!isLoggedIn ? (
                        <>
                            <NavLink
                                to="/register"
                                className={({ isActive }) => (isActive ? 'active' : '')}
                                id="register"
                                aria-current="page"
                            >
                                Create Account
                            </NavLink>
                            <NavLink
                                to="/login"
                                className={({ isActive }) => (isActive ? 'active' : '')}
                                id="login"
                                aria-current="page"
                            >
                                Login
                            </NavLink>
                        </>
                    ) : (
                        <NavLink
                            to="/logout"
                            className={({ isActive }) => (isActive ? 'active' : '')}
                            id="logout"
                            aria-current="page"
                        >
                            Logout
                        </NavLink>
                    )}
                </div>
            </div>
        </section>
    );
}

export default NavBar;
