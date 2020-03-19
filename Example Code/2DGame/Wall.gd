extends Area2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_area_entered(ball):
	if ball.name == "Ball":
		if rotation_degrees == 0: # Side wall
			ball._direction = Vector2(ball._direction.x*-1, randf() * 2 - 1).normalized()
		else: # floor or ceiling
			ball._direction = Vector2(ball._direction.x, (ball._direction.y*-1) ).normalized()
