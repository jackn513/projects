import React, { useState, useEffect } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import "../styles/login.css";
import axios from "axios";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(null);
    const [notLoggedInMessage, setNotLoggedInMessage] = useState("");
    const [loggedInMessage, setLoggedInMessage] = useState("");
    const navigate = useNavigate();

    useEffect(() => {

        const token = localStorage.getItem("token");
        if (!token) {
            setNotLoggedInMessage("You're not logged in. Please log in to access your account.");
        } else {

            setLoggedInMessage("You have successfully logged in.");
            const messageTime = setTimeout(() => {
                setLoggedInMessage("");
            }, 4000);

            // Cleanup the timeout to avoid memory leaks
            return () => clearTimeout(messageTime);
        }
    }, []);


    const handleLogin = async (e) => {
        e.preventDefault();
        setError(null);

        try {
            const response = await axios.post(
                "http://localhost:3000/users/login",
                { username, password }
            );
            localStorage.setItem("token", response.data.token);
            navigate("/");
        } catch (err) {
            setError(err.response?.data?.message || "Login failed. Please try again.");
        }
    };

    return (
        <>
            <h1 className="docMate-title">docMate</h1>
            <section className="login">
                {notLoggedInMessage && (
                    <p className="not-logged-in-message">{notLoggedInMessage}</p>
                )}

                {loggedInMessage && (
                    <p className="logged-in-message">{loggedInMessage}</p>
                )}
                <h1 className="please">Please Log in</h1>
                <form className="login-form" onSubmit={handleLogin}>
                    <section className="fields">
                        <label htmlFor="username" className="username-label-login">
                            Username <span className="required-asterisk">*</span>
                        </label>
                        <input
                            type="text"
                            id="username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            className="username-input"
                            required
                            autoFocus
                        />
                        <label htmlFor="password" className="password-label-login">
                            Password <span className="required-asterisk">*</span>
                        </label>
                        <input
                            type="password"
                            id="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            className="password-input"
                            required
                        />
                        <button type="submit" className="submit-button">
                            Log In
                        </button>
                    </section>
                </form>
                {/* Display error message */}
                {error && <p className="error-message">{error}</p>}
            </section>

            <section className="no-account">
                <p className="dont">
                    Don't have an account? Click{" "}
                    <NavLink to="/register" className="nav-link">
                        here!
                    </NavLink>
                </p>
            </section>
        </>
    );
}

export default Login;
