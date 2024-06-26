// Home.jsx
import React from "react";
import "./Home.css"; // Import CSS file for styles

export const Home = () => {
    return (
        <div className="home-container">
            <h1 className="home-title">Welcome to Plant Care!</h1>
            <div className='home-content'>
                <p className="home-about">
                    Welcome to Plant care! Here is a site in which you can browse our digital collection of plants!
                    Read all about their origins, their care, and benefits! Add them to your collection and even journal
                    about them and take note of their growth, issues, and ways in which you helped that plant turn into
                    its most beautiful self!
                </p>
            </div>
        </div>
    );
};

export default Home;
