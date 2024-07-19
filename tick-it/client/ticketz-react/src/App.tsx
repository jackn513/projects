import React from "react";
import './App.css'
import NavBar from "./Components/nav-bar.tsx";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Events from "./Pages/Events.tsx";
import Profile from "./Pages/Profile.tsx";
import Create from "./Pages/Create.tsx";
import Login from "./Pages/Login.tsx";
import Home from "./Pages/Home.tsx";
import Organizers from "./Pages/Organizers.tsx";
import OrganizerDetail from "./Pages/OrganizerDetail.tsx";

function App() {

    return (
        <>
            <div className={"app-page"}>

                <Router>
                    <NavBar />
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/events" element={<Events />} />
                        <Route path="/organizers" element={<Organizers/>}/>
                        <Route path="/organizers/:id" element={<OrganizerDetail />} />
                        <Route path="/profile" element={<Profile />} />
                        <Route path="/create" element={<Create />} />
                        <Route path="/login" element={<Login />} />
                    </Routes>
                </Router>
            </div>

        </>
    )
}

export default App
