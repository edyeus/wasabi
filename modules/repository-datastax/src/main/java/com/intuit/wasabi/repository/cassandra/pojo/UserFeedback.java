/*******************************************************************************
 * Copyright 2016 Intuit
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.intuit.wasabi.repository.cassandra.pojo;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "user_feedback")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserFeedback {
    @PartitionKey(0)
    @Column(name = "user_id")
    String userId;

    @PartitionKey(1)
    Date submitted;

    int score;

    @Column(name = "comments")
    String comment;

    @Column(name = "user_email")
    String userEmail;

    @Column(name = "contact_okay")
    boolean contactOkay;

    public String getComment() {
        return comment;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public boolean isContactOkay() {
        return contactOkay;
    }

    public int getScore() {
        return score;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setContactOkay(boolean contactOkay) {
        this.contactOkay = contactOkay;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
