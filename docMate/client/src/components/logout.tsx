import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "../assets/userContext.tsx";

function Logout({ setIsLoggedIn }) {
    const navigate = useNavigate();
    const { setUser } = useUser(); // Use the context here

    useEffect(() => {
        // Retrieve token from localStorage
        const token = localStorage.getItem("token");

        // If no token, the user is already logged out, redirect to login
        if (!token) {
            navigate("/login");
        } else {
            // Clear token and username from localStorage
            localStorage.removeItem("token");
            localStorage.removeItem("Username");
            localStorage.clear();
            setUser(null); // Clear user context
            setIsLoggedIn(false); // Update login status
            // Redirect to login page after logout
            navigate("/login");
        }
    }, [navigate, setUser, setIsLoggedIn]);

    return null; // No UI needed for this component
}

export default Logout;
