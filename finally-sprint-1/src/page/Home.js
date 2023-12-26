import React from 'react';
import Header from "../components/Header";
import Footer from "../components/Footer";
import MyForm from "../components/MyForm";
import TableData from "../components/TableData";

function Home(props) {
    return (
        <>
            <Header/>
            <div className="container">
                <MyForm/>
                <TableData/>
            </div>
            <Footer/>
        </>
    );
}

export default Home;