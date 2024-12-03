import React from "react";
import {NavLink} from "react-router-dom";
import '../styles/nav-bar.css';

function NavBar(){
    return (
        <>

            <section className="nav-bar">
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
                            to="/register"
                            className={({ isActive }) => (isActive ? 'active' : '')}
                            aria-current="page"
                        >
                            Create Account
                        </NavLink>
                    </li>
                    <li>
                        <NavLink
                            to="/login"
                            className={({ isActive }) => (isActive ? 'active' : '')}
                            aria-current="page"
                        >
                            Login
                        </NavLink>
                    </li>
                </ul>
            </section>
        </>
    )
}

export default NavBar