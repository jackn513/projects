import React, {useEffect, useState} from "react";
import { NavLink, useNavigate } from "react-router-dom";
import "../styles/login.css";
import axios from "axios";

function Login() {
    const [formData, setFormData] = useState({
        username: "",
        password: "",
    });

    const [message, setMessage] = useState("");  // Error message state
    const [loading, setLoading] = useState(false);  // Loading state
    const navigate = useNavigate();

    const [users, setUsers] = useState();
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { id, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [id]: value }));
    };

    const users =

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();  // Prevent the form from submitting normally
        setLoading(true);  // Set loading to true

        console.log("Form Data:", formData);  // Check the data being sent

        try {
            // Make the POST request to the backend
            const response = await axios.post("http://localhost:3000/users/login", formData);

            console.log("Response:", response);  // Log the response for debugging

            // Store the token (if using JWT)
            if (response.data.token) {
                localStorage.setItem("authToken", response.data.token);  // Save the token
            }

            // Redirect to home page after successful login
            navigate("/");

            // Clear form data after successful login
            setFormData({
                username: "",
                password: ""
            });
            setMessage("");  // Clear any previous error message
        } catch (error) {
            console.error("Error during login:", error);

            // Display the error message from the backend (if available)
            const errorMessage = error.response?.data?.message || "Error logging in. Please try again.";
            setMessage(errorMessage);  // Set the error message for display
        } finally {
            setLoading(false);  // Set loading to false after the request is complete
        }
    };

    return (
        <>
            <h1 className="docMate-title">docMate</h1>
            <section className="login">
                <h1 className="please">Please Log in</h1>
                <form className="login-form" onSubmit={handleSubmit}>
                    <section className="fields">
                        <label htmlFor="username" className="username-label-login">
                            Username <span className="required-asterisk">*</span>
                        </label>
                        <input
                            type="text"
                            id="username"
                            value={formData.username}
                            onChange={handleChange}
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
                            value={formData.password}
                            onChange={handleChange}
                            className="password-input"
                            required
                        />
                        <button type="submit" className="submit-button" disabled={loading}>
                            {loading ? 'Logging in...' : 'Login'}
                        </button>
                    </section>
                </form>
                {message && <p className="error-message">{message}</p>}  {/* Display error message */}
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
