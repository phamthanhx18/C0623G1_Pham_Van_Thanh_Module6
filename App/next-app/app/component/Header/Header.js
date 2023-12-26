import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-icons/font/bootstrap-icons.min.css';
import styles from './Header.module.css'
import Link from "next/link";

function Header() {
    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-light">
                <div className="container">
                    <div className="left d-flex">
                        <button className="btn d-flex align-items-center">
                            <div className={styles.icon}><i className="bi bi-list"></i></div>
                            <div className={styles.menu}><span>MENU</span></div>
                        </button>
                        <div className={styles.support}>
                            <p>Bạn cần trợ giúp?</p>
                            <h4>085 389 5555</h4>
                        </div>
                    </div>
                    <div>
                        <Link href="/"><img width={"150px"} src="/logo-scaled.png" alt=""/></Link>
                    </div>
                    <div className={styles.iconRight}>
                        <div className={styles.iconHeaderRight}><i className="bi bi-search"></i></div>
                        <div className={styles.iconHeaderRight}><i className="bi bi-bag-heart-fill"></i></div>
                        <div className={styles.iconHeaderRight}><i className="bi bi-bag-check-fill"></i></div>
                    </div>
                </div>
            </nav>
            <div className={styles.navBottom}>

            </div>
        </>
);
}

export default Header;