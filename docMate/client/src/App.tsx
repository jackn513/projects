import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';

import Register from './views/register.tsx'; // Ensure this path and file are correct
import NavBar from './components/nav-bar.tsx';
import Login from './views/login.tsx';
import Home from "./views/home.tsx";
import Logout from "./components/logout.tsx";


function App() {
    // Simulated authentication state

    return (
        <>
            <section className="app-page">
                <Router>
                    <NavBar />
                    <Routes>
                        <Route
                            path="/"
                            element={<Home/>}
                        />
                        <Route path="/register" element={<Register />} />
                        <Route path="/login" element={<Login  />} />
                        <Route path="/logout" element={<Logout />}/>

                    </Routes>
                </Router>
            </section>
        </>
    );
}



export default App;
