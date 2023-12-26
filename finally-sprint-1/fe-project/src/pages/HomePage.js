import React from 'react';
import Header from "../components/Header";
import Footer from "../components/Footer";

function HomePage(props) {
    return (
        <>
            <Header/>
            <div className="container" style={{minHeight: "90vh"}}></div>
            <Footer/>
        </>
    );
}

export default HomePage;