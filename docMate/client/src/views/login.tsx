import React, { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import "../styles/login.css";
import axios from "axios";
import { useUser } from "../assets/userContext"; // Correct import

function Login({ setIsLoggedIn }) {
    const { setUser } = useUser(); // Use the context here
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        setError(null);

        try {
            const response = await axios.post(
                "http://localhost:3000/users/login",
                { username, password }
            );
            localStorage.setItem("token", response.data.token);
            localStorage.setItem("Username", response.data.username);
            setUser(response.data); // Set user data from login response
            setIsLoggedIn(true); // Update login status
            navigate("/");  // Navigate to Home
        } catch (err) {
            setError(err.response?.data?.message || "Login failed. Please try again.");
        }
    };

    return (
        <>
            <h1 className="docMate-title">docMate</h1>
            <section className="login">
                {error && <p className="error-message">{error}</p>} {/* Display error message */}
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
