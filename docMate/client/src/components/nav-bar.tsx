import { useUser } from "../assets/userContext.tsx";
import {NavLink} from "react-router-dom";
import '../styles/nav-bar.css'
function NavBar() {
    const { user } = useUser();

    return (
        <section className="nav-bar">
            <ul className="links-nav">
                <li>
                    <NavLink
                        to="/"
                        end
                        className={({ isActive }) => (isActive ? "active" : "")}
                        id="home"
                    >
                        Home
                    </NavLink>
                </li>
            </ul>
            <div className="dropdown">
                <button className="dropbtn">
                    {user ? user.username.charAt(0).toUpperCase() : null}
                </button>
                <div className="dropdown-content">
                    {!user ? (
                        <>
                            <NavLink to="/register" id="register">Create Account</NavLink>
                            <NavLink to="/login" id="login">Login</NavLink>
                        </>
                    ) : (
                        <NavLink to="/logout" id="logout">Logout</NavLink>
                    )}
                </div>
            </div>
        </section>
    );
}

export default NavBar
