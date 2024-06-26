import React from "react";
import {Link} from "react-router-dom";
import "./navbar.css"
export const NavBar = () => {
    return <div className='nav-bar'>
        <ul className='links'>
           <Link to='/' className='link-home-nav'>Home</Link>
            <Link to='/plants' className='link-plants-nav'>Plants</Link>
            <Link to={'/soils'} className={'link-soils-nav'}>Soils</Link>
        </ul>
    </div>

}