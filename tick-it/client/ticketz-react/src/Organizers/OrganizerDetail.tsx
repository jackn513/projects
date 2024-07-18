import React, {useEffect, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";


function OrganizerDetail() {
    const [organizer, setOrganizer] = useState([]);
    const { id } = useParams<{ id: string }>();

// TODO FINISH THE USEEFFECT TO GET SINGLE ORGANIZER AND UPDATE THE CONTROLLER
    useEffect(() => {
        const fetchOrganizer = async () => {
            try {
                const response = await axios.get(`http://localhost:3000/organizers/${id}`);
                setOrganizer(response.data);
            } catch (error) {
                console.error("Error fetching the organizer: " + organizer['Id'], error);
            }
        };

        fetchOrganizer().then();
    }, [id, organizer]);

    return (
        <>
            <section className="organizer-pahe">
                <h1 className="organizer-title">Organizer</h1>
            </section>
        </>
    )
}

export default OrganizerDetail;