import React from "react";
import {Link} from "react-router-dom";
import "./navbar.css"
export const NavBar = () => {
    return <div className='nav-bar'>
        <ul className='links'>
           <Link to='/' className='link-home'>Home</Link>
            <Link to='/plants' className='link-plants'>Plants</Link>
        </ul>
    </div>

}