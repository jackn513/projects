import React from "react";
import './Footer.css'
export const Footer = () => {
    return (
        <ul className={'footer'}>
            <li>About us</li>
            <li>Contact</li>
            <li>Footer Footer</li>
            <li>Accessibility</li>
            <li>Terms of Service</li>
            <li>Privacy Policy</li>
            <li>Site Map</li>
            <li>Subscribe to our newsletter</li>
            <form>
                <input type="email" placeholder="Enter your email" />
                <button type="submit">Subscribe</button>
            </form>
            <li>&copy; 2024 PlantCare. All rights reserved.</li>
        </ul>
    )
}
