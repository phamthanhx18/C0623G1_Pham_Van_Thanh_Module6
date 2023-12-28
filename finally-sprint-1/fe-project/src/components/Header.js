import React from 'react';
import {NavLink} from "react-router-dom";

function Header() {
    return (
        <header className="p-3 mb-3 border-bottom">
            <div className="container">
                <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <NavLink to="/"
                       className="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
                        <h3>ThanhPV</h3>
                    </NavLink>

                    <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    </ul>

                    {/*<form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">*/}
                    {/*    <input type="search" className="form-control" placeholder="Search..." aria-label="Search"/>*/}
                    {/*</form>*/}
                </div>
            </div>
        </header>
    );
}

export default Header;