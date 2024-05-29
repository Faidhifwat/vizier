package com.sultan.vizier.comment;

import com.sultan.vizier.task.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private Task task;

    private String comment;

}
