import React, { useEffect, useState } from "react";
import axios from "axios";
import './Events.css';
import eventpng from '../../../react-ticketz/src/assets/event.png';
import {NavLink} from "react-router-dom";

function Events() {

    const [events, setEvents] = useState([]);
    const [filteredEvents, setFilteredEvents] = useState([]);
    const [searchCity, setSearchCity] = useState('');


    useEffect(() => {
        const fetchEvents = async () => {
            try {
                const response = await axios.get('http://localhost:3000/events');
                setEvents(response.data);
                setFilteredEvents(response.data); // Set the filtered events initially
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching events:', error);
            }
        };

        fetchEvents().then();
    }, []);

    // Filter events by city
    useEffect(() => {
        if (searchCity) {
            const filtered = events.filter(event =>
                event['Location'].toLowerCase().includes(searchCity.toLowerCase())
            );
            setFilteredEvents(filtered);
        } else {
            setFilteredEvents(events);
        }
    }, [searchCity, events]);

    const handleSearchChange = (event) => {
        setSearchCity(event.target.value);
    };

    return (
        <section className="events-page">
            <h1 className="events-title">Events</h1>
            <div className="search-container">
                <input
                    type="text"
                    className="search"
                    placeholder="Search by city"
                    value={searchCity}
                    onChange={handleSearchChange}
                />
            </div>
            <section className="events-list">
                {filteredEvents.length > 0 ? (
                    filteredEvents.map(event => (
                        <div key={event['Event Id']} className="event-item">
                            <img alt="" src="" className="event-image"/>
                            <h2 className="event-name">{event['Event Name']}</h2>
                            <NavLink to="/organizers" key={event['Organizer Id']}>
                                <h3 className="organizer-name">{event['Organizer']['Organizer Name']}</h3>
                            </NavLink>
                            <p className="event-description">{event['Event Description']}</p>
                            <p className="event-date">{event['Date']}</p>
                            <p className="event-time">{event['Time of Event']}</p>
                            <p className="event-location">{event['Location']}</p>
                            {event['Status'] !== 'cancel' && event['Status'] !== 'ended' && (
                                <>
                                    <p className="event-status">{event['Status']}</p>
                                    <button className="add">Add to my events</button>
                                </>
                            )}
                            <p className="event-price">Price TBD</p>
                        </div>
                    ))
                ) : (
                    <p>No events available.</p>
                )}
            </section>
        </section>
    );
}

export default Events;
