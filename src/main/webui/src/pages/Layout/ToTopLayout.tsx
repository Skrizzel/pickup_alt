import {childrenProp} from '../../shared/types';

const ToTopLayout = ({children}: childrenProp) => {
    return (
        <div
            style={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'flex-start',
                alignItems: 'stretch',
                alignContent: 'stretch',
            }}
        >
            {children}
        </div>
    );
};

export default ToTopLayout;
