import {NavLink, useNavigate} from "react-router-dom";
import React, { useState } from "react";
import "../styles/register.css";
import axios from "axios";

function Register() {
    const [formData, setFormData] = useState({
        username: "",
        email: "",
        password: "",
    });

    const [message, setMessage] = useState("");
    const navigate = useNavigate();
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { id, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [id]: value }));
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:3000/users/register", formData);
            navigate("/login");
            // setMessage("Registration successful! You can now log in.");
            setFormData({ username: "", email: "", password: "" });
        } catch (error) {
            setMessage("Error registering user. Please try again.");
        }
    };

    return (
        <>
            <h1 className="docMate-title-register">docMate</h1>
            <section className="register">
                <h1 className="please">Create your account</h1>
                <form className="register-form" onSubmit={handleSubmit}>
                    <section className="fields">
                        <label htmlFor="username" className="username-label-register">
                            Username <span className="required-asterisk">*</span>
                        </label>
                        <input
                            type="text"
                            id="username"
                            value={formData.username}
                            onChange={handleChange}
                            className="username-input-register"
                            required
                        />
                        <label htmlFor="email" className="email-label-register">
                            Email <span className="required-asterisk">*</span>
                        </label>
                        <input
                            type="email"
                            id="email"
                            value={formData.email}
                            onChange={handleChange}
                            className="email-input-register"
                            required
                        />
                        <label htmlFor="password" className="password-label-register">
                            Password <span className="required-asterisk">*</span>
                        </label>
                        <input
                            type="password"
                            id="password"
                            value={formData.password}
                            onChange={handleChange}
                            className="password-input-register"
                            required
                        />
                        <button type="submit" className="submit-button"
                        >
                            Register
                        </button>
                    </section>
                </form>
            </section>

            <section className="have-account">
                <p className="have">
                    Have an account? Click{" "}
                    <NavLink to="/login" className="nav-link">
                        here!
                    </NavLink>
                </p>
            </section>

            {message && <p className="message">{message}</p>}
        </>
    );
}

export default Register;
