import {Outlet} from 'react-router';
import './MainLayoutWithFooter.scss';
import Footer from '../LoggedIn/Footer/Footer';

const Layout = () => {
    return (
        <>
            <main
                style={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'stretch',
                    height: 'calc(100% - var(--footer-height))',
                    overflowY: 'auto',
                    overflowX: 'hidden',
                }}
            >
                <Outlet />
            </main>
            <Footer />
        </>
    );
};

export default Layout;
