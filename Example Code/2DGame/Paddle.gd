extends Area2D

var up_command
var down_command
var _ball_dir

func _ready():
	#var direction_name = name.to_lower()
	#up_command = direction_name + "_move_up"
	#down_command = direction_name + "_move_down"
	up_command = "move_up"
	down_command = "move_down"
	#_ball_dir = 1 if direction_name == "left" else -1


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
	#var input = Input.get_action_strength(down_command) - Input.get_action_strength(up_command)
	#position.y += input * 2
	
	position.y = get_viewport().get_mouse_position().y

func _on_area_entered(ball):
	if ball.name == "Ball":
		ball._direction = Vector2(1, randf() * 2 - 1).normalized()
