from django.urls import path
from . import views

urlpatterns = [
    path('', views.plants_index, name='plants'),
    # Add other paths as needed
]
