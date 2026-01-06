package com.jwt.example.models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JwtResponse 
{
	
	String jwtToken, username;
	
}

/*

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JwtResponse {
    private String token,username;
    // Other fields...

    
    // Private constructor to prevent direct instantiation
    private JwtResponse(Builder builder) {
        this.token = builder.token;
        // Initialize other fields...
    }

    public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;
        // Other fields...

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        // Add methods for other fields...

        public JwtResponse build() {
            return new JwtResponse(this);
        }

		public Builder username(String username) {
			// TODO Auto-generated method stub
			return null;
		}

		public Builder jwtToken(String token2) {
			// TODO Auto-generated method stub
			return null;
		}
    }
}
*/