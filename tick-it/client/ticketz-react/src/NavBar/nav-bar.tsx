import React from 'react';
import { NavLink } from 'react-router-dom';
import './NavBar.css';

function NavBar() {
    return (
        <nav className="nav-bar">
            <ul className="links-nav">
                <li>
                    <NavLink
                        to="/"
                        end
                        className={({ isActive }) => (isActive ? 'active' : '')}
                        aria-current="page"
                    >
                        Home
                    </NavLink>
                </li>
                <li>
                    <NavLink
                        to="/events"
                        className={({ isActive }) => (isActive ? 'active' : '')}
                        aria-current="page"
                    >
                        Find Events
                    </NavLink>
                </li>
            </ul>
            <ul className="links-profile">
                <li>
                    <NavLink
                        to="/profile"
                        className={({ isActive }) => (isActive ? 'active' : '')}
                    >
                        My Profile
                    </NavLink>
                </li>
                <li>
                    <NavLink
                        to="/create"
                        className="create"
                    >
                        Create Account
                    </NavLink>
                </li>
                <li>
                    <NavLink
                        to="/login"
                        className="login"
                    >
                        Login
                    </NavLink>
                </li>
            </ul>
        </nav>
    );
}

export default NavBar;
