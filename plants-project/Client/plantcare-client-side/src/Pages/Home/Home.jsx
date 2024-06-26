// Home.jsx
import React, {useEffect, useState} from "react";
import "./Home.css";
import axios from "axios"; // Import CSS file for styles
import {Link, useParams} from "react-router-dom";
// import { Plants} from "../Plants/Plants.jsx";

export const Home = () => {
    const api = axios.create({
        baseURL: "http://localhost:3000"
    });

    const [plant, setPlant] = useState(null); // Use state to hold single plant data
    const { id } = useParams(); // Retrieve 'id' parameter from URL

    useEffect(() => {
        api.get(`plants/21`)
            .then(response => {
                setPlant(response.data); // Set fetched plant data to state
                console.log(response.data)
            })
            .catch(error => {
                console.error('Error fetching plant:', error);
            });
    }, [id]); // Add 'id' to dependency array to re-fetch when 'id' changes

    if (!plant) {
        return <div>Loading...</div>; // Return loading indicator until data is fetched
    }
    return (
        <section className={'home'}>
            <section className="home-container">
                <h1 className="home-title">Welcome to Plant Care!</h1>
                <section className='home-content'>
                    <p className="home-about">
                        Welcome to Plant care! Here is a site in which you can browse our digital collection of plants!
                        Read all about their origins, their care, and benefits! Add them to your collection and even
                        journal
                        about them and take note of their growth, issues, and ways in which you helped that plant turn
                        into
                        its most beautiful self!
                    </p>

                    <section className={'links'}>
                        <section className={'plant-card-link'}>
                            <Link to='/plants' className='link-plant-card' style={{textDecoration: 'none'}}>

                                <h2 className={'plant-card-name'}>Plants</h2>
                            </Link>
                        </section>
                        <div className={'soils-card-link'}>
                            <Link to='/soils' className='link-soils-card' style={{textDecoration: 'none'}}>

                                <h2 className={'soil-card-name'}>Soils</h2>
                            </Link>
                        </div>
                    </section>
                </section>
            </section>
        </section>
    );
};

export default Home;
