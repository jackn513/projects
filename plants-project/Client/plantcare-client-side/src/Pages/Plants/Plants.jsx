import React, { useEffect, useState } from "react";
import axios from "axios";
import './Plants.css';
import {Link} from "react-router-dom";


export const Plants = () => {
    const api = axios.create({
        baseURL: "http://localhost:3000"
    });

    const [data, setData] = useState([]);

    useEffect(() => {
        api.get('/plants')
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error('Error fetching plants:', error);
            });
    }, []);

    return (
        <div>
            <h2 className='page-title'>Let there be plants!</h2>
            <div className='plants-cards'>
                {data.map(plant => (
                    <Link to={`/plant/${plant['Plant Id']}`} key={plant['Plant Id']} className='plant-link' style={{ textDecoration: 'none' }}>
                        <div key={plant['Plant Id']} className='plant-card'>
                            <img
                                src={plant['Image']} // Dynamically set the image source
                                alt={'image of ' + plant['Plant Name']} // Provide an alt text for accessibility
                                className='plant-image' // Add a class for styling (optional)
                            />
                            <p className='plant-name'>{plant['Plant Name']}</p>

                            {/* Add other details if needed */}
                        </div>
                    </Link>
                ))}
            </div>
        </div>
    );
};
