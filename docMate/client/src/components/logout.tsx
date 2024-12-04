import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Logout() {
    const navigate = useNavigate();

    useEffect(() => {
        const token = localStorage.getItem("token");

        if (!token) {

            navigate("/login");
        } else {
            // Clear the token and log the user out
            localStorage.removeItem("token");

            navigate("/login");
        }
    }, [navigate]);

    return null; // No UI needed for this component
}

export default Logout;
