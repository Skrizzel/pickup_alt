import CircularProgress from '@mui/material/CircularProgress';

const LoadingCircle = () => {
    return (
        <div style={{display: 'flex', width: '100%', height: '100%', justifyContent: 'center'}}>
            <CircularProgress />
        </div>
    );
};

export default LoadingCircle;
