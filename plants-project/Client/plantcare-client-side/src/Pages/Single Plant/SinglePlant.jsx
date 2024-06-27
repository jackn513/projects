import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import './SinglePlant.css'
export const SinglePlant = () => {
    const api = axios.create({
        baseURL: "http://localhost:3000"
    });

    const [plant, setPlant] = useState(null); // Use state to hold single plant data
    const { id } = useParams(); // Retrieve 'id' parameter from URL

    useEffect(() => {
        api.get(`plants/${id}`)
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
        <div className='plant-details'>
            <div className='single-plant-card'>
                <img
                    src={plant['Image']}
                    alt={`image of ${plant['Plant Name']}`}
                    className='single-plant-image'
                />
                <h1 className='single-plant-name'>{plant['Plant Name']}</h1>
                <h2 className={'single-plant-sname'}>{plant['Scientific Name']}</h2>
                {/* Add other details if needed */}
            </div>
            <blockquote className={'single-plant-desc'}>{plant['Plant Description']}</blockquote>
            <blockquote className={'single-plant-soil'}>{plant['Soil Type']}</blockquote>
        </div>
    );
};
