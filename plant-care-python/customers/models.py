from django.contrib.auth.models import User
from django.db import models, transaction


class Customer(models.Model):
    # user = models.OneToOneField(User, on_delete=models.CASCADE)
    customer_name = models.CharField(max_length=128)
    profile_bio = models.CharField(max_length=500)
    profile_image = models.ImageField(upload_to='profile_pics', null=True, blank=True)
    password = models.CharField(max_length=128)
    email = models.EmailField(max_length=254, unique=True)
    role = models.CharField(max_length=50, default='user')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.customer_name

    class Meta:
        db_table = 'customer'


