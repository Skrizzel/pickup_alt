import {childrenProp} from '../../shared/types';

const ToBottomLayout = ({children}: childrenProp) => {
    return (
        <div
            style={{
                height: '100%',
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'flex-end',
            }}
        >
            {children}
        </div>
    );
};

export default ToBottomLayout;
