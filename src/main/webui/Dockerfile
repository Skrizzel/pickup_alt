# Use an official Node.js image as the base image
FROM node:20.15

# Set the working directory in the container
WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

# Build the frontend
#RUN npm run build

EXPOSE 5173

CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]
