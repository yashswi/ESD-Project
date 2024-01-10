import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import '../Styles/domain.css'
import axios from 'axios'

const DomainList = () => {
  const [domains, setDomains] = useState([]);
  const [selectedDomain, setSelectedDomain] = useState(null);
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    // Fetch the list of domains when the component mounts
    const fetchData = async () => {
      try {
        const response = await axios.get('/api/v1/domain');
        // console.log("This is the data I am looking for", response.data);
        setDomains(response.data);
      } catch (error) {
        console.error('Error fetching domains:', error);
        // Handle errors here if needed
      }
    }
    fetchData();
  }, []);

  const handleDomainChange = async (event) => {
    const domainId = event.target.value;
    setSelectedDomain(domainId);

    try {
      const response = await axios.get(`api/v1/byDomain/${domainId}`);
      const data = response.data;
      setCourses(data);
    } catch (error) {
      console.error('Error fetching courses:', error);
    }
  };

  return (
    <div>
      <h1>ACADEMIA</h1>
      <div class="center-container ">
        <label htmlFor="domainDropdown">Select a Domain: </label>
        <select id="domainDropdown" onChange={(e) => handleDomainChange(e)}>
          <option value="">Select a domain</option>
          {domains.map(domain => (
            <option key={domain.id} value={domain.id}>{domain.program}</option>
          ))}

        </select>
      </div>

      {selectedDomain && (
        <div>
          <h2>COURSE TIME TABLE</h2>
          <table>
            <thead>
              <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Faculty Name</th>
                <th>Faculty Email</th>
                <th>Day</th>
                <th>Time</th>
                <th>Room</th>
                <th>Students</th>

              </tr>
            </thead>
            <tbody>
              {courses.map(course => (
                <tr key={course.id}>
                  <td>{course.id}</td>
                  <td>{course.name}</td>
                  <td>{course.faculty && course.faculty.f_name}</td>
                  <td>{course.faculty && course.faculty.f_email}</td>
                  <td>{course.schedule && course.schedule.day}</td>
                  <td>{course.schedule && course.schedule.time}</td>
                  <td>{course.schedule && course.schedule.room}</td>
                  <td>
                    <button>
                      <Link to={`/courses/${course.id}/students`}>View Students</Link>
                    </button>
                  </td>

                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default DomainList;
